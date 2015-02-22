//@TODO: get drunk.

public class MickesBar implements Bar{
	@Override
	public Drink getDrink(Drinker drinker, Drink drinkPreference){

		if(Drinker.isTooDrunkToGetInToClub()){
			throw new TooDrunkException("{} is too drunk to be served", drinker);
		}

		return DrinksFactory.getDrink(drinkPreference);

	}

	public static void main(String[] args){
		new MickesBar();
	}
}

private interface Bar{
	Drink getDrink(Drink drinkPreference);
}

private class DrinksFactory{
	private static List<Drink> drinksArray = Arrays.asList(new BluéLagoon(), new Appletini(),
						 new SouthSide(), new Mojito(), new Pineapplé("remix"));

	public static Drink getDrink(Drink drink){
		if(!drinks.contains(drinkPreference)){
			throw new NoSuchDrinkException("We don't have {}", drinkPreference);
		}
		return drinksArray.get(drink);
	}

}

private class DrinkerImpl{
	private float BloodAlocholContent;
	private static final List<String> bannedNames = Arrays.asList("Micke", "Väggen", "Flamman", "Peach", "Flame"); 
	private String name;

	public DrinkerImpl(float bloodAlocholContent){
		this.BloodAlocholContent = bloodAlocholContent;
	}

	public boolean isTooDrunkToGetInToClub(){
		if(bannedNames.contains(this.name)){
			return true;
		}
		if(this.getBloodAlcoholContent() > 1.0){
			return true;
		} 
		return false;
	}

	public float getBloodAlocholContent(){
		return this.BloodAlocholContent;
	}
}

private interface Drinker{
	boolean isTooDrunkToGetInToClub();
	float getBloodAlocholContent();
}