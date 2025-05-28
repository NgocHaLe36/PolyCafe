/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import poly.cafe.entity.Bill;
import poly.cafe.util.XAuth;
import poly.cafe.util.XQuery;

/**
 *
 * @author lengh
 */
public class BillDAOImpl implements BillDAO {

    String createSql = "…";
    String updateSql = "…";
    String deleteSql = "…";
    String findAllSql = "…";
    String findByIdSql = "…";
    String findByUsernameSql = "…";
    String findByCardIdSql = "…";
    String findByTimeRangeSql = "SELECT * FROM Bills WHERE Checkin BETWEEN ? AND ? ORDER BY Checkin DESC";
    String findServicingByCardId = "SELECT * FROM Bills WHERE CardId=? AND Status=0"; 

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Bill findById(Long id) {
        return null;
    }

    @Override
    public List<Bill> findByUsername(String username) {
        return null;
    }

    @Override
    public List<Bill> findByCardId(Integer cardId) {
        return null;
    }

    @Override
    public Bill create(Bill entity) {
        return null;
    }

    @Override
    public void update(Bill entity) {
        return;
    }

    @Override
    public List<Bill> findAll() {
        return null;
    }

    @Override
    public Bill findByUsername(Long username) {
        return null;
    }

    @Override
    public List<Bill> findByTimeRange(Date begin, Date end) {
        Timestamp beginTs = new Timestamp(begin.getTime());
        Timestamp endTs = new Timestamp(end.getTime());
        return XQuery.getBeanList(Bill.class, findByTimeRangeSql, beginTs, endTs);
    }

    @Override
    public Bill findServicingByCardId(Integer cardId) {
        String sql = "SELECT * FROM Bills WHERE Username=? AND Checkin BETWEEN ? AND ?";
        Bill bill = XQuery.getSingleBean(Bill.class, sql, cardId);
        if (bill == null) { // không tìm thấy -> tạo mới
            Bill newBill = new Bill();
            newBill.setCardId(cardId);
            newBill.setCheckin(new Date());
            newBill.setStatus(0); // đang phục vụ
            newBill.setUsername(XAuth.user.getUsername());
            bill = this.create(newBill); // insert
        }
        return bill;
    }

    @Override
    public List<Bill> findByUserAndTimeRange(String username, Date begin, Date end) {
        String sql = "SELECT * FROM Bills";
        return XQuery.getBeanList(Bill.class, sql);
    }
}
