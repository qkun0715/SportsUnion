package com.hjy.sports.student.modify.info;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.fy.baselibrary.base.CommonDialog;
import com.hjy.sports.R;

/**
 * 输入框 dialog
 * Created by fangs on 2017/12/23.
 */
public class EditDialog extends CommonDialog implements View.OnClickListener {

    Bundler bundler;

    TextView tvDialogTitle;
    EditText editContent;
    TextView tvDialogCancel;
    TextView tvDialogOk;


    @Override
    protected int getContentLayout() {
        return R.layout.dialog_edit;
    }

    @Override
    protected void baseInit() {
        tvDialogTitle = mRootView.findViewById(R.id.tvDialogTitle);
        editContent = mRootView.findViewById(R.id.editContent);
        tvDialogCancel = mRootView.findViewById(R.id.tvDialogCancel);
        tvDialogOk = mRootView.findViewById(R.id.tvDialogOk);

        tvDialogTitle.setText(bundler.getTitleId());
        tvDialogCancel.setOnClickListener(this);
        tvDialogOk.setOnClickListener(this);

        setWidthPixels(-1);
        super.baseInit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvDialogCancel:
                dismiss();
                break;
            case R.id.tvDialogOk:
                if (null != bundler && null != bundler.getListener())
                    bundler.getListener().onClick(this, editContent);
                break;
        }
    }

    public void setBundler(Bundler bundler) {
        this.bundler = bundler;
    }

    /**
     * 弹窗 确定 按钮 回调接口
     */
    interface SelectorListener {
        void onClick(EditDialog dialog, EditText edit);
    }

    static class Bundler {
        int titleId = -1;
        SelectorListener listener;

        public Bundler() {
        }

        public int getTitleId() {
            return titleId;
        }

        public Bundler setTitleId(int titleId) {
            this.titleId = titleId;

            return this;
        }

        public SelectorListener getListener() {
            return listener;
        }

        public Bundler setListener(SelectorListener listener) {
            this.listener = listener;
            return this;
        }

        public EditDialog create() {
            EditDialog editDialog = new EditDialog();
            editDialog.setBundler(this);

            return editDialog;
        }
    }
}
