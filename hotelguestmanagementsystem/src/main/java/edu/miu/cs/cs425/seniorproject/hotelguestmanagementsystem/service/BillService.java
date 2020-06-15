package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Bill;

import java.time.LocalDate;
import java.util.List;

public interface BillService {

    public Bill initiateBill(Bill bill);

    public Bill getBill(Long billId);

    public List<Bill> getAllBills();

    public void discardBill(Long billId);
}
