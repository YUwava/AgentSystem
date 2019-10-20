package cm.agency.service.impl;

import cm.agency.dao.Report_typeMapper;
import cm.agency.entity.As_accountdetailEntity;
import cm.agency.service.Report_typeSeverice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 报表管理
 */
@Service
public class Report_typeimpl implements Report_typeSeverice {
    @Autowired
   private Report_typeMapper report_typeMapper;

    public void setReport_typeMapper(Report_typeMapper report_typeMapper) {
        this.report_typeMapper = report_typeMapper;
    }

    @Override
    public List<As_accountdetailEntity> Report_Severice() {
        return report_typeMapper.Select_Report();
    }
}
