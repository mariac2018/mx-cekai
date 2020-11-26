package string;//package string;
//
//import org.apache.commons.lang3.StringUtils;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class Demo1 {
//    public static void main(String[] args) {
//
//
//    }
//
//    public void insert(final PortalDetail portalDetail){
//        final String sql = "INSERT INTO portal_detail(px, user_id, bb, bs, op, rp, os, rt, ii, pi, an, be, ti, bpi, pt, ri, ts, po, ps, add_time) " +
//                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        jdbcTemplate.update(new PreparedStatementCreator() {
//            @Override
//            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setString(1, portalDetail.getPx());
//                preparedStatement.setString(2, portalDetail.getUserId());
//                preparedStatement.setString(3, portalDetail.getBb());
//                preparedStatement.setString(4, portalDetail.getBs());
//                preparedStatement.setString(5, portalDetail.getOp());
//                preparedStatement.setString(6, portalDetail.getRp());
//                preparedStatement.setString(7, portalDetail.getOs());
//                preparedStatement.setString(8, portalDetail.getRt());
//                preparedStatement.setString(9, portalDetail.getIi());
//                preparedStatement.setString(10, portalDetail.getPi());
//                preparedStatement.setString(11, portalDetail.getAn());
//                preparedStatement.setString(12, portalDetail.getBe());
//                preparedStatement.setString(13, portalDetail.getTi());
//                preparedStatement.setString(14, portalDetail.getBpi());
//                preparedStatement.setString(15, portalDetail.getPt());
//                preparedStatement.setString(16, portalDetail.getRi());
//                preparedStatement.setString(17, portalDetail.getTs());
//                preparedStatement.setString(18, portalDetail.getPo());
//                preparedStatement.setString(19, portalDetail.getPs());
//                preparedStatement.setTimestamp(20, new Timestamp(new Date().getTime()));
//                return preparedStatement;
//            }
//        });
//    }
//
//    public void insertBatch(final List<PortalDetail> portalDetails) {
//
//        long start = System.currentTimeMillis();
//
//        String sql = "INSERT INTO portal_detail(px, user_id, bb, bs, op, rp, os, rt, ii, pi, an, be, ti, bpi, pt, ri, ts, po, ps, add_time) " +
//                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
//                PortalDetail portalDetail = portalDetails.get(i);
//                preparedStatement.setString(1, portalDetail.getPx());
//                preparedStatement.setString(2, portalDetail.getUserId());
//                preparedStatement.setString(3, portalDetail.getBb());
//                preparedStatement.setString(4, portalDetail.getBs());
//                preparedStatement.setString(5, portalDetail.getOp());
//                preparedStatement.setString(6, portalDetail.getRp());
//                preparedStatement.setString(7, portalDetail.getOs());
//                preparedStatement.setString(8, portalDetail.getRt());
//                preparedStatement.setString(9, portalDetail.getIi());
//                preparedStatement.setString(10, portalDetail.getPi());
//                preparedStatement.setString(11, portalDetail.getAn());
//                preparedStatement.setString(12, portalDetail.getBe());
//                preparedStatement.setString(13, portalDetail.getTi());
//                preparedStatement.setString(14, portalDetail.getBpi());
//                preparedStatement.setString(15, portalDetail.getPt());
//                preparedStatement.setString(16, portalDetail.getRi());
//                preparedStatement.setString(17, portalDetail.getTs());
//                preparedStatement.setString(18, portalDetail.getPs());
//                preparedStatement.setString(19, portalDetail.getPo());
//                preparedStatement.setTimestamp(20, new Timestamp(new Date().getTime()));
//            }
//
//            @Override
//            public int getBatchSize() {
//                return portalDetails.size();
//            }
//        });
//        long end = System.currentTimeMillis();
//        LOGGER.error("线程共执行: {}毫秒", (end-start));
//    }
//
//}
