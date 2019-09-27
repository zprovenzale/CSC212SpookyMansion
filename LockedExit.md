# What is LockedExit?

Suppose you play the following game: going straight through some rooms, and encounter a locked door:

```
You are in the grand entrance hall of a large building.
The front door is locked. How did you get here?
 [0] There are stairs leading down.
 [1] There are stairs leading up.
 [2] There is a red door.
> 2

You've found the kitchen. You smell old food and some kind of animal.
 [0] There is a red door.
 [1] There is a dumbwaiter.
> 1

You crawl into the dumbwaiter. What are you doing?
 [0] Take it to the bottom.
 [1] Take it to the middle-level.
 [2] Take it up to the top.
> 0

You have found the secret room.
 [0] There is a locked door.
 [1] There is a trap-door. It looks like a one-way trip.
> 0
You cannot unlock that right now. Maybe with a key?
```

Maybe with a key.

You start again:

```
You are in the grand entrance hall of a large building.
The front door is locked. How did you get here?
 [0] There are stairs leading down.
 [1] There are stairs leading up.
 [2] There is a red door.
> stuff
You have nothing.

You are in the grand entrance hall of a large building.
The front door is locked. How did you get here?
 [0] There are stairs leading down.
 [1] There are stairs leading up.
 [2] There is a red door.
> 0

You have found the basement of the mansion.
It is darker down here.
You get the sense a secret is nearby, but you only see the stairs you came from.
 [0] There are stairs leading up.
 [1] There are stairs leading down.
> 1

You've found the bottom of the stairs. There are a lot of cobwebs here.
There is a small key here.
 [0] Take the stairs back up to the basement.
 [1] Take the stairs back up to the hall.
> take
You take the small key.

You've found the bottom of the stairs. There are a lot of cobwebs here.
 [0] Take the stairs back up to the basement.
 [1] Take the stairs back up to the hall.
> stuff
You have the small key.
```

Awesome. This time, when you try to proceed through the locked door...

```
You have found the secret room.
 [0] There is a locked door.
 [1] There is a trap-door. It looks like a one-way trip.
> 0
This is a very long hallway.
It looks as though someone has scratched a number: 1 into the ground.
 [0] Go back.
 [1] Go forward.
> 1
```

It works! Soon:

```
You have found the crypt.
It is scary here, but there is an exit to outside.
Maybe you'll be safe out there.
>>> GAME OVER <<<
```
