package com.example.callrecorder.ui;

import com.example.callrecorder.domain.entities.Calls;

import java.util.List;

/**
 * Created by Михайлик on 06.12.2015.
 */
    public interface CallsView {
        public void showCalls(List<Calls> list);
    }
