//import Game.domain.User;

public interface UserDao {
    //����ӿڱ�֤��������

        //ע��
        public abstract void regist(User user);
        //��¼
        public abstract boolean isLogin(String userName,String passWord);
        //���а�
}
