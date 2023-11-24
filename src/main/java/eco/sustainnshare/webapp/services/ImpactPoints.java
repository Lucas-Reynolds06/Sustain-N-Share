package eco.sustainnshare.webapp.services;

public enum ImpactPoints {
    CLOTHING(30, "Clothing"),
    FURNITURE(50, "Furniture"),
    ELECTRONICS(30, "Electronics"),
    VEHICLES(100, "Vehicles"),
    BOOKS(15, "Books"),
    TOYS(25, "Toys & Games"),
    APPLIANCES(60, "Appliances"),
    SPORTS(20, "Sports Equipment"),
    GARDENING(30, "Gardening Tools"),
    ART_SUPPLIES(15,"Arts & Crafts Supplies"),
    KITCHENWARE(20, "Kitchenware"),
    OTHER(10, "Other");
    private String categoryName;
    private int points;

    ImpactPoints(int points, String categoryName){
        this.points = points;
        this.categoryName = categoryName;
    }

    public static int getPointsByCategory(String category){
        for (var p : ImpactPoints.values()){
            if (p.categoryName.equals(category)){
                return p.points;
            }
        }
        return 0;
    }
}
