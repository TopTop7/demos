package poppy.jdbc;

import java.sql.*;

public class Test {
    public void excute() throws SQLException {
        Connection conn = null;
        PreparedStatement smt = null;
        ResultSet resultset = null;
        try {
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=utf-8", "root", "123456");
            if (conn != null) {
                System.out.println("连接成功");
            }
            //手动提交事务
            conn.setAutoCommit(false);
            //插入数据操作
            String insertSql = "insert into author(name) values(?)";
            smt = conn.prepareStatement(insertSql);
            smt.setString(1, "唐家三少");
            int result = smt.executeUpdate();
            if (result > 0) {
                System.out.println("添加成功");
            }
            smt.clearParameters();

            //修改数据操作
            String updateSql = "update author set name=? where id=?";
            smt = conn.prepareStatement(updateSql);
            smt.setString(1, "莫言");
            smt.setInt(2, 2);
            int updateResult = smt.executeUpdate();
            if (updateResult > 0) {
                System.out.println("修改成功");
            }
            smt.clearParameters();

            //查询数据操作
            String sql = "select *from author where id =?";
            smt= conn.prepareStatement(sql);
            smt.setInt(1,2);
            resultset = smt.executeQuery();
            while (resultset.next()) {
                int uid = resultset.getInt("id");
                System.out.println(String.format("id:%s,name:%s", uid,
                        resultset.getString("name")));
            }

            conn.commit();
        } catch (SQLException e) {
            System.out.println(e);
            conn.rollback();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //4、释放资源 写到finally里面，防止报错不能执行资源回收
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (smt != null) {
                try {
                    smt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        new Test().excute();
    }
}
