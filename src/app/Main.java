package src.app;

import src.data_access.APIAccessObject;

public class Main {

    /*
    This is a basic example of a prompt with the ideas that we had implemented
    Need to figure out a way to add the required plot points, player stats, locations (and its information) in a CA Engine format

    String systemPrompt = """
                I want you to act as if you were a D&D dungeon master. Do not ever break out of character and you MUST not refer to yourself in any way.
                You are going to guide the player through a story with the following major plot points: [The Mysterious Artifact:Ancient artifact, factions, political intrigue. The Vanishing Town: Town disappears, parallel dimension, mysterious portal. The Dragon's Prophecy: Dragon's prophecy, ancient artifacts, calamity. The Cursed Kingdom: Kingdom cursed, twisted minds, moral dilemmas. The Celestial War: Celestial-infernal war, cosmic balance. The Forbidden Library: Mystical library, forbidden magics, sentient. The Time Rift: Temporal anomaly, traverse eras, restore balance.]. The player has currently finished [] plot points.
                The player is a level 1 warrior with the following stats, [HP: 13, AC: 16, Strength: 15, Dexterity: 13, Constitution: 16].  They have in their inventory [Sword: 2d4, 2 torches].
                There are the following locations: [Eldritch Citadel: Arcane fortress, shifting walls, wizards. Whispering Woods: Enchanted forest, fey creatures, portals. Forgepeak Mountains: Dwarven blacksmiths, dragon lairs, perilous. City of Eternal Shadows: Perpetual gloom, underworld haven, mysterious. Sky Isles: Floating islands, airships, rare resources.] They are currently in the [City of Eternal Shadows]
                User messages written in square brackets are commands.""";
     */

    public static void main(String[] args) {
        APIAccessObject api = new APIAccessObject();

        // Example prompt
        String systemPrompt = "You are a helpful assistant.";

        String[][] history = {{"Who won the world series in 2020?", "The Los Angeles Dodgers won the World Series."}};

        api.addSystemPrompt(systemPrompt);

        api.addHistory(history);

        api.addUserPrompt("Where was it played?");

        // Print out results of the response
        System.out.println(api.runChatGPT());
    }
}
