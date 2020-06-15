package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.impl;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.model.Bill;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.repository.BillRepository;
import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl  implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public Bill initiateBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill getBill(Long billId) {
        Optional<Bill> bill = billRepository.findById(billId);
        return bill.orElse(null);
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public void discardBill(Long billId) {
        billRepository.deleteById(billId);

    }
}
