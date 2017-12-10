# First test for square root


def sqrt(x, precision):
    """Compute square root using Heron's method."""
    old_guess = 0.5 * (x + 1)
    guess = 0.5 * (old_guess + x / old_guess)
    while not (-precision <= old_guess - guess <= precision):
        guess, old_guess = 0.5 * (guess + x / guess), guess  
    return guess


def test_sqrt():
    precision = 0.00001
    assert 3.0 - precision < sqrt(9.0, precision) < 3.0 + precision