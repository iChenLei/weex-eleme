package com.weex.sample.fragment;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.weex.sample.R;

/**
 * Created by yangjingchou on 2017/12/19.
 */

public class TestFragment extends Fragment implements IWXRenderListener {

    //JS来源 可以是本地 也可以是服务器端
    private String mBundleUrl;
    //用来装载weex页面的容器
    private FrameLayout rootView;
    //weexsdk实例
    private WXSDKInstance mWXSDKInstance;

    public TestFragment(){}

    public static TestFragment newInstance(String url) {
        Bundle args = new Bundle();
        TestFragment fragment = new TestFragment();
        args.putString(WXSDKInstance.BUNDLE_URL,url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(getActivity(), R.layout.weex_test,null);
        rootView = (FrameLayout)view.findViewById(R.id.fragment_test);

        mBundleUrl = getArguments() != null ? getArguments().getString(WXSDKInstance.BUNDLE_URL) : null;

        mWXSDKInstance = new WXSDKInstance(getActivity());
        mWXSDKInstance.registerRenderListener(this);
        mWXSDKInstance.render("weex fragment test", WXFileUtils.loadAsset(mBundleUrl,getActivity()),null,null, WXRenderStrategy.APPEND_ASYNC);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView.getParent() != null) {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }
        System.out.print("[chenlei-weex]  What happened? ");
        return rootView;
    }

    @Override
    public void onViewCreated(WXSDKInstance mWXSDKInstance, View view) {
        rootView.addView(view);
        System.out.print("[chenlei-weex] Add view successful?");
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {
        WXLogUtils.d("[weex] render success");
    }

    @Override
    public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {
        WXLogUtils.d("[weex] refresh success");
    }

    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {
        WXLogUtils.d("[weex] Oooooooops, error occured! ");
    }
}
