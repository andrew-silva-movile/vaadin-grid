package com.vaadin.prototype.wc.gwt.client.widgets.grid;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.query.client.js.JsUtils;
import com.vaadin.prototype.wc.gwt.client.widgets.WCVGrid;
import com.vaadin.prototype.wc.gwt.client.widgets.grid.GData.GColumn;

public class GJsObjectDataSource extends GDataSource {

    private final JsArray<JavaScriptObject> jso;

    public GJsObjectDataSource(JsArray<JavaScriptObject> jso, WCVGrid grid) {
        super(grid);
        assert JsUtils.isArray(jso);
        this.jso = jso;
        size = jso.length();
    }

    @Override
    protected void requestRows(
            int firstRowIndex,
            int numberOfRows,
            com.vaadin.client.data.AbstractRemoteDataSource.RequestRowsCallback<com.google.gwt.core.client.JsArrayMixed> callback) {
        List<GColumn> cols = wcGrid.getCols();
        setRowDataFromJs(firstRowIndex, numberOfRows, cols, jso);
    }

}