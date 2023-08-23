package dat3.car;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarsRepository;
import dat3.car.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class DeveloperData implements ApplicationRunner {

    @Autowired
    CarsRepository carsRepository;

    @Autowired
    MemberRepository memberRepository;

    public DeveloperData(CarsRepository carsRepository, MemberRepository memberRepository) {
        this.carsRepository = carsRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Cars
        List<String[]> carBrandsAndModels = Arrays.asList(new String[]{"Toyota", "Camry"},
                new String[]{"Ford", "Mustang"},
                new String[]{"Honda", "Civic"},
                new String[]{"BMW", "M3"},
                new String[]{"Mercedes", "C300"},
                new String[]{"Audi", "A4"},
                new String[]{"Volkswagen", "Golf"},
                new String[]{"Subaru", "Impreza"},
                new String[]{"Chevrolet", "Malibu"},
                new String[]{"Nissan", "Altima"},
                new String[]{"Porsche", "911"},
                new String[]{"Mazda", "3"},
                new String[]{"Lexus", "IS"},
                new String[]{"Dodge", "Charger"},
                new String[]{"Jeep", "Wrangler"},
                new String[]{"Hyundai", "Sonata"},
                new String[]{"Kia", "Optima"},
                new String[]{"Jaguar", "XF"},
                new String[]{"Cadillac", "ATS"},
                new String[]{"Land Rover", "Discovery"},
                new String[]{"Acura", "TLX"},
                new String[]{"Infiniti", "Q50"},
                new String[]{"Mitsubishi", "Lancer"},
                new String[]{"Lincoln", "MKZ"},
                new String[]{"Buick", "LaCrosse"},
                new String[]{"Volvo", "S60"},
                new String[]{"Mini", "Cooper"},
                new String[]{"Alfa Romeo", "Giulia"},
                new String[]{"Fiat", "500"},
                new String[]{"Maserati", "Ghibli"},
                new String[]{"Tesla", "Model 3"},
                new String[]{"Genesis", "G70"},
                new String[]{"Bentley", "Continental GT"},
                new String[]{"Aston Martin", "Vantage"},
                new String[]{"Rolls-Royce", "Ghost"},
                new String[]{"Ferrari", "488 GTB"},
                new String[]{"Lamborghini", "Huracan"},
                new String[]{"McLaren", "570S"},
                new String[]{"Bugatti", "Chiron"},
                new String[]{"Pagani", "Huayra"},
                new String[]{"Suzuki", "Swift"},
                new String[]{"Peugeot", "208"},
                new String[]{"Citroen", "C3"},
                new String[]{"Renault", "Clio"},
                new String[]{"Skoda", "Octavia"},
                new String[]{"Seat", "Ibiza"},
                new String[]{"Opel", "Astra"},
                new String[]{"Saab", "9-3"},
                new String[]{"Lancia", "Ypsilon"});

        Random random = new Random();
        List<Integer> discounts = Arrays.asList(2,5,10,15,20,25,30,35,40,45);

        for (String[] carData : carBrandsAndModels) {
            double price = 200 + random.nextInt(801);
            int discount = discounts.get(random.nextInt(discounts.size()));

            Car car = new Car(carData[0], carData[1], price, discount);
            carsRepository.save(car);
        }

        //Member
        List<Member> members = new ArrayList<>();

        members.add(new Member("johnDoe123", "john.doe@example.com", "securePassword1!", "John", "Doe", "123 Elm Street", "Springfield", "12345"));
        members.add(new Member("aliceSmith89", "alice.smith@example.net", "aliceSecurePassword!23", "Alice", "Smith", "456 Maple Drive", "Shelbyville", "67890"));
        members.add(new Member("robertBrown", "robert.brown@example.org", "robBrown!Pass56", "Robert", "Brown", "789 Oak Avenue", "Capitol City", "11223"));
        memberRepository.saveAll(members);
    }
}
