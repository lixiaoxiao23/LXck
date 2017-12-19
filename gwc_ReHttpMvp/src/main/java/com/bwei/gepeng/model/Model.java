package com.bwei.gepeng.model;


import com.bwei.gepeng.entity.CartBean;
import com.bwei.gepeng.entity.GoodsShowBean;
import com.bwei.gepeng.entity.MessageBean;
import com.bwei.gepeng.http.RetrofitUtils;
import com.bwei.gepeng.presenter.NewsPresenter;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;

public class Model implements IModel{

    private NewsPresenter presenter;
    public Model(NewsPresenter presenter) {
        this.presenter = presenter;
    }

    /*@Override
    public void getData(Map<String, String> map) {
        Flowable<MessageBean<List<Newslist>>> flowable = RetrofitUtils.getInstance().getApiService().getNews(map);
        presenter.get(flowable);
    }*/

    @Override
    public void getData(Map<String, String> map, String tag) {
        if(tag.equals("cart")){
            Flowable<MessageBean<List<CartBean>>> flowable = RetrofitUtils.getInstance().getApiService().getCart(map);
            presenter.get2(flowable,tag);
        }else if(tag.equals("goods")){
            Flowable<MessageBean<GoodsShowBean>> flowable = RetrofitUtils.getInstance().getApiService().getNews(map);
            presenter.get(flowable,tag);
        }

    }
}
