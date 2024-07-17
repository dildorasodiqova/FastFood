package uz.example.fastfood.service.mealService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.example.fastfood.dtos.createDto.MealCreateDto;
import uz.example.fastfood.dtos.responcseDto.MealResponseDto;
import uz.example.fastfood.enties.CategoryEntity;
import uz.example.fastfood.enties.MealEntity;
import uz.example.fastfood.exception.DataNotFoundException;
import uz.example.fastfood.repository.MealRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService{
    private final ModelMapper modelMapper;
    private final MealRepository mealRepository;
    private final
    public MealResponseDto createMeal(MealCreateDto createMealDTO) {
        MealEntity meal = modelMapper.map(createMealDTO, MealEntity.class);
        CategoryEntity category = categoryRepository.findById(createMealDTO.getCategoryId())
                .orElseThrow(() -> new DataNotFoundException("Category not found"));
        meal.setCategory(category);

        MealEntity savedMeal = mealRepository.save(meal);
        return modelMapper.map(savedMeal, MealResponseDto.class);
    }

    public MealResponseDto getMeal(UUID mealId) {
        MealEntity meal = mealRepository.findById(mealId)
                .orElseThrow(() -> new DataNotFoundException("Meal not found"));
        return modelMapper.map(meal, MealResponseDto.class);
    }

}
