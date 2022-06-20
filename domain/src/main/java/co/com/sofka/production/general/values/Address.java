package co.com.sofka.production.general.values;


import java.util.Map;
import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class Address implements ValueObject<Map<String, String>> {
    private final String country;
    private final String city;
    private final String address;

    public Address(String country, String city, String address) {
        this.country = Objects.requireNonNull(country);
        this.city = Objects.requireNonNull(city);
        this.address = Objects.requireNonNull(address);

        if (this.country.isBlank() || this.city.isBlank() || this.address.isBlank()) {
            throw new IllegalArgumentException("Your address is invalid");
        }
    }

    @Override
    public Map<String, String> value() {
        return Map.of("Country", country, "City", city, "Address", address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address that = (Address) o;
        return Objects.equals(value(), that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }
}
