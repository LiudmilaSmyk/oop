package org.example;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {

    private static final String FILE_PATH = "laptops.json";
    private List<Laptop> laptops = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> addLaptop(@RequestBody Laptop laptop) {
        laptops.add(laptop);
        saveLaptopsToFile();
        return ResponseEntity.ok("Laptop added successfully");
    }

    @GetMapping
    public ResponseEntity<List<Laptop>> getAllLaptops() {
        loadLaptopsFromFile();
        return ResponseEntity.ok(laptops);
    }

    private void saveLaptopsToFile() {
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            new Gson().toJson(laptops, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadLaptopsFromFile() {
        try (FileReader file = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Laptop>>(){}.getType();
            laptops = new Gson().fromJson(file, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

