package org.assignmentdemo.service;

import org.assignmentdemo.db.DbContext;
import org.assignmentdemo.model.Grade;

import java.util.ArrayList;

public class GradeService extends DbContext<Grade> {
    public GradeService() {
        super();
    }

    @Override
    public void insert(Grade model) {

    }

    @Override
    public void update(Grade model) {

    }

    @Override
    public void delete(Grade model) {

    }

    @Override
    public Grade get(int id) {
        return null;
    }

    @Override
    public ArrayList<Grade> list() {
        return null;
    }
}
