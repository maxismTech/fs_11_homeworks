package hw08;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Map<String, String> schedule;
    private Family family;

    public Human() {
        this.schedule = new HashMap<>();
    }

    public Human(String name, String surname, String birthDate, int iq, Map<String, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(birthDate, formatter);
        this.birthDate = date.atStartOfDay().toInstant(java.time.ZoneOffset.UTC).toEpochMilli();
        this.schedule = schedule != null ? schedule : new HashMap<>();
    }

    public String describeAge() {
        LocalDate birth = LocalDate.ofEpochDay(birthDate / (24 * 60 * 60 * 1000));
        LocalDate now = LocalDate.now();
        Period period = Period.between(birth, now);
        return String.format("%d років, %d місяців, %d днів",
                period.getYears(),
                period.getMonths(),
                period.getDays());
    }

    public void greetPet() {
        if (family != null && !family.getPets().isEmpty()) {
            for (Pet pet : family.getPets()) {
                System.out.println("Привіт, " + pet.getNickname());
            }
        }
    }

    public void describePet() {
        if (family != null && !family.getPets().isEmpty()) {
            for (Pet pet : family.getPets()) {
                String sly = pet.getTrickLevel() > 50 ? "дуже хитрий" : "майже не хитрий";
                System.out.printf("У мене є %s, йому %d років, він %s.%n",
                        pet.getSpecies(), pet.getAge(), sly);
            }
        }
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.ofEpochDay(birthDate / (24 * 60 * 60 * 1000));
        return String.format("Human{name='%s', surname='%s', birthDate='%s', iq=%d, schedule='%s'}",
                name, surname, date.format(formatter), iq, schedule);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate &&
                iq == human.iq &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iq, schedule);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public Map<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
} 