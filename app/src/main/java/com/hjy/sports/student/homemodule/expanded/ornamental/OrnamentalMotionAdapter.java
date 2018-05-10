package com.hjy.sports.student.homemodule.expanded.ornamental;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fy.baselibrary.entity.CourseDetails;
import com.hjy.sports.R;

import java.util.List;

/**
 * Created by Gab on 2018/3/14 0014..
 *
 */

public class OrnamentalMotionAdapter extends BaseQuickAdapter<CourseDetails.DataBean.GroupsBean.ActionsBean.NotesBean, BaseViewHolder> {

    public OrnamentalMotionAdapter(int layoutResId, @Nullable List<CourseDetails.DataBean.GroupsBean.ActionsBean.NotesBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, CourseDetails.DataBean.GroupsBean.ActionsBean.NotesBean item) {
        if (!TextUtils.isEmpty(item.getName())){
            helper.setText(R.id.tv_title, item.getName());
        }
        if (!TextUtils.isEmpty(item.getDesc())){
            helper.setText(R.id.tv_content, item.getDesc());
        }
    }
}
