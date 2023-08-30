package dat3.car.repository;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarsRepositoryTest {

    @Autowired
    CarsRepository carsRepository;

    @Autowired
    MemberRepository memberRepository;

    MemberService memberService;

    boolean isInitialized = false;

    @BeforeEach
    void setUp() {
        if(!isInitialized) {
            carsRepository.deleteAll();
            memberRepository.deleteAll();
            carsRepository.save(new Car("Toyota", "Camry", 500, 10));
            carsRepository.save(new Car("Tesla", "Model3", 700, 15));
            memberRepository.save(new Member("johnDoe123", "john.doe@example.com", "securePassword1!", "John", "Doe", "123 Elm Street", "Springfield", "12345"));
            isInitialized = true;
        }
    }

    @Test
    public void deleteAllCars() {
        carsRepository.deleteAll();
        assertEquals(0, carsRepository.count());
    }

    @Test
    public void deleteAllMembers() {
        memberRepository.deleteAll();
        assertEquals(0, memberRepository.count());
    }

    @Test
    void findByBrand() {
        Car car = carsRepository.findByBrand("Tesla");
        assertEquals("Tesla", car.getBrand());
    }

    @Test
    void findByUserName() {
        Member member = memberRepository.findByUsername("johnDoe123");
        assertEquals("johnDoe123", member.getUsername());
    }
}