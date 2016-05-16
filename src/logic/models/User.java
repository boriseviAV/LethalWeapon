package logic.models;

public class User {
    private int userId;
    private String login;
    private String passwordHash;
    private String email;
    private String role;

    public User(int userId, String login, String passwordHash, String email, String role) {
        this(login, passwordHash, email, role);
        this.userId = userId;
    }

    public User(String login, String passwordHash, String email, String role) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
