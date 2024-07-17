package uz.example.fastfood.enties;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "meals")
public class MealEntity extends BaseEntity{
    private String name;
    private int readyTime; // in minutes
    private BigDecimal cost;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity category;
    private String description;
    private String image; // Assuming this is a URL or file path
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
