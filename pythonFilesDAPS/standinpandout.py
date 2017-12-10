def capitalize_input():
    import sys
    line = sys.stdin.readline()
    cap_line = line.upper() + "\n"
    sys.stdout.write(cap_line)


if __name__ == "__main__":
    capitalize_input()