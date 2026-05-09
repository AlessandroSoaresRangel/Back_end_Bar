package br.com.koisas_bar.backend.domain;


import jakarta.persistence.*;


import java.util.Set;

@Entity
@Table(name = "Bill")
public class Bill {

    private final Float COUVER_PRICE = 5f;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "bill")
    private Set<Orders> orders;

    @Column(name = "consumed_value", nullable = false)
    private Float consumedValue;

    @Column(name = "service_tax", nullable = false)
    private Float serviceTax;

    @Column(name = "couver_value", nullable = false)
    private Float couverValue;

    @Column(name = "number_person", columnDefinition = "integer default 0")
    private Integer numberPerson;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private RestaurantTable table;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Float getConsumedValue() {
        return consumedValue;
    }


    public Float getServiceTax() {
        return serviceTax;
    }


    public Float getCouverValue() {
        return couverValue;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }


    private void consumedValueCalc() {

        this.consumedValue = 0.0f;

        for(Orders forOrders : orders) {
            this.consumedValue += forOrders.orderSubTotal();
        }

    }

    private void  serviceTaxCalc() {
        this.serviceTax =  consumedValue * 0.1f;
    }

    private void couverCalc() {

        this.couverValue = COUVER_PRICE * numberPerson;
    }

    public Float totalDueValue() {

        consumedValueCalc();
        serviceTaxCalc();
        couverCalc();

        return consumedValue + serviceTax + couverValue;
    }

}
