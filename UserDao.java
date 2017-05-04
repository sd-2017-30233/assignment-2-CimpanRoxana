 
import com.javasampleapproach.marshalling.enumeratii.Tip;
import com.javasampleapproach.marshalling.liste.UserList;
import com.javasampleapproach.marshalling.model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Roxana on 04-May-17.
 */

public class UserDao {

    public UserList getAllUsers() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
        Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();
        UserList userListFromXml = (UserList) jaxbMarshaller.unmarshal(new File("utilizator.xml"));
        userListFromXml.getListOfUsers();
        return userListFromXml;
    }

    public User getUser(String userName) throws JAXBException{
        UserList userList = getAllUsers();
        List<User> utilizatori = userList.getListOfUsers();
        User user = new User();
        for(User i : utilizatori){
            if (i.getUserName().equals(userName))
                user = i;
        }
        System.out.println(user.getName());
        return user;
    }
    public void deleteUser(User user) throws  JAXBException{
        UserList userList = getAllUsers();
        List<User> l = (List<User>) userList.getListOfUsers();
        UserList userList1 = new UserList();
        List<User> l2= new ArrayList<>();
        for (User user1 : l)
        {
            if (!user.getName().equals(user1.getName()))
                l2.add(user1);
        }
        userList1.setListOfUsers(l2);
        JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        jaxbMarshaller.marshal(userList1,new File("utilizator.xml"));
        jaxbMarshaller.marshal(userList1,System.out);
    }

    public void addUser(User user) throws JAXBException{
        UserList userList = getAllUsers();
        userList.add(user);
        JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        jaxbMarshaller.marshal(userList,new File("utilizator.xml"));
        jaxbMarshaller.marshal(userList,System.out);
    }

    public void updateEmployeeAddress(User user, Tip userType) throws JAXBException{
        UserList userList = getAllUsers();
        List<User> l = (List<User>) userList.getListOfUsers();
        UserList userList1 = new UserList();
        List<User> l2 = new ArrayList<>();
        for (User i : l){
            if (user.getName().equals(i.getName()))
            {
                i.setType(userType);
                l2.add(i);
            }
            else  l2.add(i);
        }
        userList1.setListOfUsers(l2);
        JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        jaxbMarshaller.marshal(userList1,new File("utilizator.xml"));
        jaxbMarshaller.marshal(userList1,System.out);
    }

}
