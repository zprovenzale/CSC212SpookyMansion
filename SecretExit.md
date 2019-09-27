# What is Secret Exit? Consider the following gameplay:

Going down to the basement has always been a dead-end.

```
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
```

What if we could allow the user to type "search" as a special, secret command.

```
> search
You search the room for additional exits.
```

It doesn't do much, but it triggers a (new) method on Place that will "reveal" any exits that are hidden.

```

You have found the basement of the mansion.
It is darker down here.
You get the sense a secret is nearby, but you only see the stairs you came from.
 [0] There are stairs leading up.
 [1] There is a trap door that was obscured by dust!
 [2] There are stairs leading down.
> 1

You have found the secret room.
 [0] There is a locked door.
 [1] There is a trap-door. It looks like a one-way trip.
> 
```
