import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import shared.Instance;
import util.linalg.DenseVector;

@JsonPropertyOrder({"age", "worker", "industry", "occupation", "education", "wage", "enrolled",
"marital", "industry_code", "occupation_code", "race", "hispanic", "sex", "union", "reason",
"fulltime", "gains", "losses", "dividends", "filer", "region", "state", "household", "summary",
"weight", "migration_msa", "migration_reg", "migration_move", "lived", "migration_prev", "employer_num_persons",
"family_members", "father_country", "mother_country", "birth_country", "citizenship",
        "self_employed", "questionnare", "veterans", "weeks", "year", "income"})
public class CensusRecord {

    int age;
    int worker;
    int industry;
    int occupation;
    int education;
    double wage;
    int enrolled;
    int marital;
    int industry_code;
    int occupation_code;
    int race;
    int hispanic;
    int sex;
    int union;
    int reason;
    int fulltime;
    double gains;
    double losses;
    double dividends;
    int filer;
    int region;
    int state;
    int household;
    int summary;
    double weight;
    int migration_msa;
    int migration_reg;
    int migration_move;
    int lived;
    int migration_prev;
    int employer_num_persons;
    int family_members;
    int father_country;
    int mother_country;
    int birth_country;
    int citizenship;
    int self_employed;
    int questionnare;
    int veterans;
    int weeks;
    int year;
    int income;

    public CensusRecord() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWorker() {
        return worker;
    }

    public void setWorker(int worker) {
        this.worker = worker;
    }

    public int getIndustry() {
        return industry;
    }

    public void setIndustry(int industry) {
        this.industry = industry;
    }

    public int getOccupation() {
        return occupation;
    }

    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }

    public int getMarital() {
        return marital;
    }

    public void setMarital(int marital) {
        this.marital = marital;
    }

    public int getIndustry_code() {
        return industry_code;
    }

    public void setIndustry_code(int industry_code) {
        this.industry_code = industry_code;
    }

    public int getOccupation_code() {
        return occupation_code;
    }

    public void setOccupation_code(int occupation_code) {
        this.occupation_code = occupation_code;
    }

    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }

    public int getHispanic() {
        return hispanic;
    }

    public void setHispanic(int hispanic) {
        this.hispanic = hispanic;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getUnion() {
        return union;
    }

    public void setUnion(int union) {
        this.union = union;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
        this.reason = reason;
    }

    public int getFulltime() {
        return fulltime;
    }

    public void setFulltime(int fulltime) {
        this.fulltime = fulltime;
    }

    public double getGains() {
        return gains;
    }

    public void setGains(double gains) {
        this.gains = gains;
    }

    public double getLosses() {
        return losses;
    }

    public void setLosses(double losses) {
        this.losses = losses;
    }

    public double getDividends() {
        return dividends;
    }

    public void setDividends(double dividends) {
        this.dividends = dividends;
    }

    public int getFiler() {
        return filer;
    }

    public void setFiler(int filer) {
        this.filer = filer;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getHousehold() {
        return household;
    }

    public void setHousehold(int household) {
        this.household = household;
    }

    public int getSummary() {
        return summary;
    }

    public void setSummary(int summary) {
        this.summary = summary;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMigration_msa() {
        return migration_msa;
    }

    public void setMigration_msa(int migration_msa) {
        this.migration_msa = migration_msa;
    }

    public int getMigration_reg() {
        return migration_reg;
    }

    public void setMigration_reg(int migration_reg) {
        this.migration_reg = migration_reg;
    }

    public int getMigration_move() {
        return migration_move;
    }

    public void setMigration_move(int migration_move) {
        this.migration_move = migration_move;
    }

    public int getLived() {
        return lived;
    }

    public void setLived(int lived) {
        this.lived = lived;
    }

    public int getMigration_prev() {
        return migration_prev;
    }

    public void setMigration_prev(int migration_prev) {
        this.migration_prev = migration_prev;
    }

    public int getEmployer_num_persons() {
        return employer_num_persons;
    }

    public void setEmployer_num_persons(int employer_num_persons) {
        this.employer_num_persons = employer_num_persons;
    }

    public int getFamily_members() {
        return family_members;
    }

    public void setFamily_members(int family_members) {
        this.family_members = family_members;
    }

    public int getFather_country() {
        return father_country;
    }

    public void setFather_country(int father_country) {
        this.father_country = father_country;
    }

    public int getMother_country() {
        return mother_country;
    }

    public void setMother_country(int mother_country) {
        this.mother_country = mother_country;
    }

    public int getBirth_country() {
        return birth_country;
    }

    public void setBirth_country(int birth_country) {
        this.birth_country = birth_country;
    }

    public int getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(int citizenship) {
        this.citizenship = citizenship;
    }

    public int getSelf_employed() {
        return self_employed;
    }

    public void setSelf_employed(int self_employed) {
        this.self_employed = self_employed;
    }

    public int getQuestionnare() {
        return questionnare;
    }

    public void setQuestionnare(int questionnare) {
        this.questionnare = questionnare;
    }

    public int getVeterans() {
        return veterans;
    }

    public void setVeterans(int veterans) {
        this.veterans = veterans;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public Instance convertToInstance()
    {
        Instance label = new Instance(this.income);
        DenseVector data = new DenseVector(41);
        data.set(0, age);
        data.set(1, worker);
        data.set(2, industry);
        data.set(3, occupation);
        data.set(4, education);
        data.set(5, wage);
        data.set(6, enrolled);
        data.set(7, marital);
        data.set(8, industry_code);
        data.set(9, occupation_code);
        data.set(10, race);
        data.set(11, hispanic);
        data.set(12, sex);
        data.set(13, union);
        data.set(14, reason);
        data.set(15, fulltime);
        data.set(16, gains);
        data.set(17, losses);
        data.set(18, dividends);
        data.set(19, filer);
        data.set(20, region);
        data.set(21, state);
        data.set(22, household);
        data.set(23, summary);
        data.set(24, weight);
        data.set(25, migration_msa);
        data.set(26, migration_reg);
        data.set(27, migration_move);
        data.set(28, lived);
        data.set(29, migration_prev);
        data.set(30, employer_num_persons);
        data.set(31, family_members);
        data.set(32, father_country);
        data.set(33, mother_country);
        data.set(34, birth_country);
        data.set(35, citizenship);
        data.set(36, self_employed);
        data.set(37, questionnare);
        data.set(38, veterans);
        data.set(39, weeks);
        data.set(40, income);
        return new Instance(data, label);
    }

    @Override
    public String toString() {
        return "CensusRecord{" +

                ", employer_num_persons=" + employer_num_persons +
                ", family_members=" + family_members +
                ", father_country=" + father_country +
                ", mother_country=" + mother_country +
                ", birth_country=" + birth_country +
                ", citizenship=" + citizenship +
                ", self_employed=" + self_employed +
                ", questionnare=" + questionnare +
                ", veterans=" + veterans +
                ", weeks=" + weeks +
                ", year=" + year +
                ", income=" + income +
                '}';
    }
}
