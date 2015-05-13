# Social App

## Prerequisites

Make sure you've got the following installed:

* Java 8
* Gradle 2.x (only for development)

## Usage

Download the [latest binary distribution](https://github.com/patforna/social/releases).

Then unpack it and execute the provided start script:

    $ unzip social-*.zip
    $ cd social-*/
    $ bin/social
    ------------------------------------------------------------------------
     Hi! Please type some commands:
    ------------------------------------------------------------------------
     <user> -> <msg>           Post a new message
     <user>                    Read posts
     <user> follows <other>    Follow other user
     <user> wall               Read wall posts
     Ctrl-C                    Quit.
    ------------------------------------------------------------------------

    >

## Development

Clone the source code. To see what's possible, run:

    $ gradle tasks

To compile, test and package the app, run:

    $ ./build.sh

To start the app, run:

    $ ./run.sh

## Known Issues

I know these issues exist but decided not to fix them:

* for posts newer than 1 min, message reads "moments ago" instead of "x seconds ago".
* wall posts are not ordered by date.

## Notes

These were some topics that got me scratching my chin:

* should I put command parsing logic in `CommandParser` or in `Command` objects?
* should I introduce `equals`/`hashCode` on `Command` objects just so I can test?
* is there really no better way to use regexes in java?
* should `Command#execute()` return something more expressive than `Object`?
* should `Command#execute()` return `Optional<?>`
* should timestamp creation happen in `Command` or `Post` object?
* should I have a `User` object?
* how do I feel about making `SocialApp#run` public for easier testing?
* should I abstract away input/output into a `Console` object?