def test_euclid_exc():
    try:
        r = GCD(5, -1) # tiggers exception.
        assert False # skip rest of block.
    except ArithmeticError as e:
                # Exec. except block for  Exception'
                assert "Must be positive int." in str(e)
            except:
        assert False # skip other blocks. finally:
        assert True # Always execute finally.