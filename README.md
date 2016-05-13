# NRK Share Java libraries

Configured with [Gradle build system](http://gradle.org/).

## Build

	./gradlew build


## Gradle artifacts signing

Configure gpg subkeys according to this:
<http://superuser.com/questions/879977/how-to-have-a-different-pass-phrase-for-a-gpg-subkey>

Import the (exported) subkey into a new and fresh gnupg-directory, for instance `/home/YOU/.gradle-gnupg`.

Then setup gradle.properties in your home directory with these properties:

	signing.keyId=YOUR_SUBKEY_ID
	signing.password=YOUR_SUBKEY_PASSPHRASE
	signing.secretKeyRingFile=/home/YOU/.gradle-gnupg/secring.gpg


## LICENSE

All Java source code: MIT License

See file: LICENSE
