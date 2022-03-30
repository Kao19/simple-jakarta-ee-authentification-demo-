/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack;

/**
 *
 * @author HP
 */
public class employe {
    private String Login;
    private String Password;
    private String Profile;
    
    public employe(String l, String p, String pro){
        this.Login=l;
        this.Password=p;
        this.Profile=pro;
    }
    
    public employe(){
        this("","","");
    }
    
    public String getLogin(){
        return Login;
    }
    
    
    public String getPassword(){
        return Password;
    }
    
    public String getProfile(){
        return Profile;
    }
    
    
    public void setProfile(String p){
        this.Profile=p;
    }
    
    public void setLogin(String l){
        this.Login=l;
    }
    
    public void setPassword(String p){
        this.Password=p;
    }
}
