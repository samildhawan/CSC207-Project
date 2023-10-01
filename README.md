# CSC207-Project
Project for CSC207 Survivors

- Project domain & kind of application:

A text-based adventure game inspired by Dungeons & Dragons,
where the player can decide to take actions with certain percent of likelihood

- Link to the documentation for an API: 

https://platform.openai.com/docs

- Screenshot of using a tool to try out the API:

![screenshot of using a tool](Hoppscotch.png)

- Example output of running Java code:

{
  "id": "chatcmpl-84y0YRCVN04JpDxcWar1akJJ8rfSp",
  "object": "chat.completion",
  "created": 1696194674,
  "model": "gpt-3.5-turbo-0613",
  "choices": [
    {
      "index": 0,
      "message": {
        "role": "assistant",
        "content": "Bonjour, le monde !"
      },
      "finish_reason": "stop"
    }
  ],
  "usage": {
    "prompt_tokens": 15,
    "completion_tokens": 5,
    "total_tokens": 20
  }
}

- List of any technical problems blocking progress (if any):

Possible limitations when it comes to how often we can call the API.
Need to figure out how to integrate it into the narrative.
