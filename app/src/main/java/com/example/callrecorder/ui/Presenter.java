package com.example.callrecorder.ui;

import com.example.callrecorder.data.base.Repository;
import com.example.callrecorder.domain.entities.Calls;

import java.util.List;

/**
 * Created by Михайлик on 06.12.2015.
 */
public class Presenter {
    CallsView viewer;
    Repository repository;

    public Presenter(CallsView viewer, Repository repository) {
        this.viewer = viewer;
        this.repository = repository;
    }
    public void showCalls()
         {
             List<Calls> list = repository.getCalls();
             viewer.showCalls(list);
         }
    public void insertCalls(Calls calls)
    {
        repository.insertCalls(calls);
    }


}
