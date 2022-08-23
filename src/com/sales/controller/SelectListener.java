/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.controller;

import com.sales.model.Invoice;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.sales.view.InvoiceFrame;
import java.util.ArrayList;
import com.sales.model.InvoiceTableModel;
import com.sales.model.Line;
import com.sales.model.LineTableModel;

/**
 *
 * @author Ashraf Sholok
 */
public class SelectListener implements ListSelectionListener {

    private InvoiceFrame frame;

    public SelectListener(InvoiceFrame frame) {
        this.frame = frame;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedIndex = frame.getInvoiceTable().getSelectedRow();
        if (selectedIndex != -1) {
            Invoice CurrentInvoice = frame.getInvoices().get(selectedIndex);
            frame.getInvoiceNumLabel().setText("" + CurrentInvoice.getNum());
            frame.getInvoiceDateField().setText(CurrentInvoice.getDate());
            frame.getInvoiceNameField().setText(CurrentInvoice.getCustomer());
            frame.getInvoiceTotalLabel().setText("" + CurrentInvoice.getInvoiceTotal());

            LineTableModel lineTableModel = new LineTableModel(CurrentInvoice.getLines());
            frame.getLineTable().setModel(lineTableModel);
            lineTableModel.fireTableDataChanged();
        }
    }

}
