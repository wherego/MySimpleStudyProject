package com.bianl.readingwhat.ui.activity.guide;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.base.BaseActivity;
import com.bianl.readingwhat.base.BaseModel;
import com.bianl.readingwhat.ui.activity.home.HomeAty;

import butterknife.OnClick;

public class GuideAty extends BaseActivity {

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_guide_aty;
    }

    @OnClick(R.id.guide_tv)
    protected void goNextPage(){
        HomeAty.startHomeAty(this);
    }
    @Override
    protected void initView() {

    }
}
