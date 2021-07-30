/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pleystation.model.controller;

import java.util.List;
import pleystation.model.IDataModel;

/**
 *
 * @author Aksal
 */
abstract class IDataController<D extends IDataModel> extends DBConnection {
    abstract boolean addData(D dataModel);
    abstract boolean updateData(D dataModel);
    abstract boolean deleteData(int id);
    abstract D getData(int id);
    abstract List<D> getAllData(int page);
    abstract List<D> searchData(String query, int page);
}
