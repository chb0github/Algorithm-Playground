const assert = require('assert')
const justify = require('./justify')

describe('Testing justification', function () {
    describe('Basic justification', function () {
        it('should pass with the default test', function () {

            const actual = justify('The quick brown fox jumps over the lazy dog.', 52)

            assert.equal(actual, 'The  quick  brown  fox  jumps  over  the  lazy  dog.');
        });

        it('should fail if the string is greater than the justification length', function () {

            try {
                const actual = justify('The quick brown fox jumps over the lazy dog.', 10)
            }
            catch (problem) {

            }
        });
        it('should pass with the default test', function () {

            const actual = justify('The quick brown fox jumps over the lazy dog.', 100)

            assert.equal(actual, 'The        quick        brown        fox        jumps        over        the        lazy        dog.');
        });
    });
});