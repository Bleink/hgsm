package edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.impl;

import edu.miu.cs.cs425.seniorproject.hotelguestmanagementsystem.service.HomeService;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class HomeServiceImpl implements HomeService {
    @Override
    public String[] getCurouselPictureList() {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\curousel");
        String[] fileList = file.list();
        return fileList;
    }

    @Override
    public String[] getIndexBottomPictureList() {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\indexBottomPictures");
        String[] fileList = file.list();
        return fileList;
    }

}
