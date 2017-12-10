

def estimate_pi(precision):
    """Due to the nature that this function depends on 9999999 random coordinates, the probability of getting the exact
    value of pi is quite small and can only be achieved by either doing more computations (which would make the program
    very slow) or by comparing the value estimated with the actual value of pi. I did not take this approach even though
    I would have found a more precise answer because I think this defeats the purpose of finding pi"""
    import math
    import random

    hits = 0
    total = 9999999

    if precision > 6:
        raise Exception("Precision is too high")

    for hit in range(0, total):
        # generating coordinates between 0 and 1
        x = random.random()
        y = random.random()

        # applying pythagoras to get length from origin to point
        hypotenuse = math.sqrt((x**2) + (y**2))

        # check if hypotenuse is less than the radius of the sector
        if hypotenuse < 1.0:
            hits += 1

    pi = (hits / total) * 4
    print(str("%." + str(precision) + "f") % pi)
    return pi


print(estimate_pi(8))
