package com.neusoft.service;

import com.neusoft.entity.ModelListShow;
import com.neusoft.util.FileOperator;

import java.util.List;

public class MLSManager {
    private List<ModelListShow> modelListShowList;
    private static MLSManager singletonInstance;

    private MLSManager() {
        modelListShowList = FileOperator.loadData("ModelListShows.json", ModelListShow.class);
    }

    //单例模式
    public static MLSManager getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new MLSManager();
        }
        return singletonInstance;
    }
    //增
    public boolean addModelListShow(ModelListShow modelListShow) {
        modelListShowList.add(modelListShow);
        FileOperator.writeData(modelListShow, "ModelListShows.json");
        return true;
    }
    //删
    public void removeModelListShow(ModelListShow modelListShow) {
        modelListShowList.remove(modelListShow);
        FileOperator.writeData(modelListShowList, "ModelListShows.json");
    }

    public List<ModelListShow> getModelListShows() {
        return modelListShowList;
    }
}
