import java.text.DecimalFormat;

class Lab14A {
  public static void main(String args[]) {
    BuildingBlueprint buildingOne = new BuildingBlueprint();
    BuildingBlueprint buildingTwo = new BuildingBlueprint(30, 30, 0.75f);

    System.out.println("Year 2020:");
    System.out.println(buildingOne);
    System.out.println(buildingTwo);

    System.out.println("\nMany years pass.\n\nYear 2043:");

    buildingOne.setOccupancy(0.0f);
    buildingTwo.setOccupancy(1.0f);

    System.out.println(buildingOne);
    System.out.println(buildingTwo);

    if (buildingOne.getOccupancy() == buildingTwo.getOccupancy()) {
      System.out.println("\nLooks like both buildings have the same amount of occupants.");
    } else if (buildingOne.getStories() > buildingTwo.getStories()) {
      if (buildingOne.getOccupancy() > buildingTwo.getOccupancy()) {
        System.out.println("\nLooks like people prefer taller buildings.");
      } else {
        System.out.println("\nLooks like people prefer shorter buildings.");
      }
    } else {
      if (buildingTwo.getOccupancy() > buildingOne.getOccupancy()) {
        System.out.println("\nLooks like people prefer taller buildings.");
      } else {
        System.out.println("\nLooks like people prefer shorter buildings.");
      }
    }
  }
}

class BuildingBlueprint {
  private DecimalFormat df = new DecimalFormat("0.0");

  private int stories, apartments;
  private float occupancy;
  private boolean fullyOccupied;
  private int buildingNumber;

  private static int buildingCount = 0;

  public BuildingBlueprint() {
    this.stories = 10;
    this.apartments = 20;
    this.occupancy = 1.0f;
    this.fullyOccupied = true;

    buildingCount += 1;
    this.buildingNumber = buildingCount;
  }

  public BuildingBlueprint(int stories, int apartments, float occupancy) {
    this.stories = stories;
    this.apartments = apartments;
    this.occupancy = occupancy;
    this.fullyOccupied = this.occupancy == 1.0f;

    buildingCount += 1;
    this.buildingNumber = buildingCount;
  }

  public int getStories() {
    return this.stories;
  }

  public float getOccupancy() {
    return this.occupancy;
  }

  public void setOccupancy(float occupancy) {
    this.occupancy = occupancy < 0.0f ? 0.0f : occupancy > 1.0f ? 1.0f : occupancy;
    this.fullyOccupied = this.occupancy == 1.0f ? true : false;
  }

  public int getApartments() {
    return this.apartments;
  }

  public boolean getFullyOccupied() {
    return this.fullyOccupied;
  }

  public String toString() {
    return "Building " + this.buildingNumber + " has " + this.stories + " floors, " + this.apartments + " apartments, and is " + df.format(this.occupancy * 100f) + "% occupied. Full? " + this.fullyOccupied;
  }
}