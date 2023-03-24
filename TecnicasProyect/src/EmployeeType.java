public enum EmployeeType {
    
    GENERALSERVICES("General Services Employee"),
    HUMANTALENT("Human Talent Coordinator"),
    SECURITY("Security Employee"),
    PRODUCTION( "Production Employee"),
    CEO("CEO");

    private String value;

    EmployeeType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
