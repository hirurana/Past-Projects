def GCD(a,b):
    """Compute the GCD of two positive int."""
    if not(a>0 and b>0):
        raise ArithmeticError("%s, %s: Must be positive int." % (a,b))
    while a != b:
        if a > b:
            a=a-b
        else:
            b=b-a
    return a

def test_euclid_exc():
    try:
        r = GCD(5, -1) # tiggers exception.
        assert False # skip rest of block.
    except ArithmeticError as e:
        # Exec. except block for  Exception'
        assert "Must be positive int." in str(e)
        print(e)
    except:
        assert False # skip other blocks.
    finally:
        assert True # Always execute finally.

test_euclid_exc()
