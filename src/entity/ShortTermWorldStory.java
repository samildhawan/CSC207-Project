package src.entity;

import java.util.ArrayList;
import java.util.List;

public class ShortTermWorldStory implements WorldStory {

    private List<String[]> history = new ArrayList<>();

    private String prompt = """
                    I want you to act as if you were a D&D dungeon master. Do not ever break out of character and you MUST not refer to yourself in any way.
                    You are going to guide the player through a story with the following major plot points: [The Mysterious Artifact:Ancient artifact, factions, political intrigue. The Vanishing Town: Town disappears, parallel dimension, mysterious portal. The Dragon's Prophecy: Dragon's prophecy, ancient artifacts, calamity. The Cursed Kingdom: Kingdom cursed, twisted minds, moral dilemmas. The Celestial War: Celestial-infernal war, cosmic balance. The Forbidden Library: Mystical library, forbidden magics, sentient. The Time Rift: Temporal anomaly, traverse eras, restore balance.].
                    There are the following locations: [Eldritch Citadel: Arcane fortress, shifting walls, wizards. Whispering Woods: Enchanted forest, fey creatures, portals. Forgepeak Mountains: Dwarven blacksmiths, dragon lairs, perilous. City of Eternal Shadows: Perpetual gloom, underworld haven, mysterious. Sky Isles: Floating islands, airships, rare resources.] They are currently in the [City of Eternal Shadows]
                    User messages written in square brackets are commands.""";

    @Override
    public void addEvent(String event) {}

    @Override
    public String getEvent() { return null; }

    @Override
    public void addHistory(String[] history) {
        this.history.add(history);
    }

    @Override
    public List<String[]> getHistory() {
        return history.subList(Math.max(0, history.size() - 3), history.size());
    }

    @Override
    public String getPrompt() {
        return prompt;
    }
}
