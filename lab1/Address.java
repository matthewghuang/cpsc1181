/**
    Represents an address.
 */
public class Address {
    private String number;
    private String street;
    private String city;
    private String province;
    private String postalCode;

    /**
        Construct an address.
        @param number The house/building number.
        @param street The street name.
        @param city The city name.
        @param province The province.
        @param postalCode The postal code. 
     */
    public Address(String number, String street, String city, String province, String postalCode) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    /**
        Get the address as a string. 
        @return The address formatted as a string.
     */
    public String toString() {
        return String.format("%s %s, %s, %s, %s", this.number, this.street, this.city, this.province, this.postalCode);
    }
}