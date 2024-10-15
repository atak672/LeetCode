import os
import re
from datetime import datetime
import inflect

p = inflect.engine()

# Directories
SOURCE_DIR = r""  # Your scraped solutions directory
DEST_DIR = r""  # Target directory for organized solutions

# Ensure the destination directory exists
os.makedirs(DEST_DIR, exist_ok=True)

# def format_problem_name(problem_name):
#     """Format problem name into ClassName and FileName styles."""
#     name_parts = problem_name.split('-')
#     class_name = ''.join([part.capitalize() for part in name_parts]) + "Solution"
#     file_name = '-'.join([part.capitalize() for part in name_parts])
#     return class_name, file_name

def convert_digits_to_words(part):
    """Convert any digits in a part of the name to words using inflect."""
    # Replace digits with their word counterparts
    return re.sub(r'\d+', lambda x: p.number_to_words(x.group(), andword=''), part)

def format_problem_name(problem_name):
    """Format problem name into ClassName and FileName styles."""
    # Convert digits to words
    formatted_name = convert_digits_to_words(problem_name)

    # Capitalize the first letter of each word and handle digits
    formatted_parts = []
    for part in re.findall(r'[A-Za-z]+|\d+', formatted_name):  # Find all words and digits
        if part.isdigit():  # If it's a digit, convert to word
            formatted_parts.append(p.number_to_words(part, andword='').capitalize())
        else:
            formatted_parts.append(part.capitalize())  # Capitalize the alphabetic parts

    # Join parts to create the class name and file name
    class_name = ''.join(formatted_parts) + "Solution"
    file_name = '-'.join(formatted_parts)  # Join parts with hyphens for file name

    return class_name, file_name

def get_most_recent_file(directory):
    """Select the most recent solution file based on its timestamp."""
    files_with_dates = []

    for file in os.listdir(directory):
        try:
            # Extract timestamp from filenames like '6-26-2022, 2_47_24 PM'
            timestamp_str = re.search(r'\d{1,2}-\d{1,2}-\d{4}, \d{1,2}_\d{2}_\d{2} [APM]{2}', file).group()
            timestamp = datetime.strptime(timestamp_str, '%m-%d-%Y, %I_%M_%S %p')
            files_with_dates.append((file, timestamp))
        except AttributeError:
            continue  # Skip files without valid timestamps

    # Return the most recent file
    if files_with_dates:
        return max(files_with_dates, key=lambda x: x[1])[0]
    return None

def process_files():
    """Iterate through problem directories, pick latest solution, and format."""
    for problem in os.listdir(SOURCE_DIR):
        problem_path = os.path.join(SOURCE_DIR, problem, 'Accepted')

        # Ensure 'Accepted' folder exists and has files
        if os.path.exists(problem_path) and os.path.isdir(problem_path):
            most_recent_file = get_most_recent_file(problem_path)

            if most_recent_file:
                # Read the content of the most recent solution file
                with open(rf"{os.path.join(problem_path, most_recent_file, "Solution.java")}", 'r') as f:
                    code = f.read()


                # Format the problem name for class and filename
                class_name, file_name = format_problem_name(problem)

                # Replace 'class Solution' with 'class ProblemNameSolution'
                modified_code = re.sub(r'\bclass Solution\b', f'class {class_name}', code)

                # Save the modified code to the destination directory
                output_path = os.path.join(DEST_DIR, f"{file_name}.java")
                with open(output_path, 'w') as f:
                    f.write(modified_code)

                print(f"Processed: {output_path}")

# Run the script
if __name__ == "__main__":
    process_files()