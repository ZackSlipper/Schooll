def readNextDataLine(file):
	line = file.readline()
	while not line.strip():
		line = file.readline()
	return line

def readTeams():
	with open("duom1.txt", "r") as file:
		teamCount = int(readNextDataLine(file))
		teams = {}

		for teamId in range(teamCount):
			teamMemberCount = int(readNextDataLine(file))
			teamMembers = {}

			for _ in range(teamMemberCount):
				teamMemberData = readNextDataLine(file).strip().split()

				teamMemberName = f"{teamMemberData[0]} {teamMemberData[1]}"
				teamMemberMinutes = int(teamMemberData[2])
				teamMemberSeconds = int(teamMemberData[3])

				teamMembers[teamMemberName] = (teamMemberMinutes, teamMemberSeconds)

			teams[teamId+1] = teamMembers
		return teams

def sortTeamMembers(teams):
	for teamId in teams:
		teams[teamId] = dict(sorted(teams[teamId].items(), key=lambda item: item[1][0]*60 + item[1][1]))
	return teams

def selectTopTeamMembers(teams):
	selectedTeamMembers = {} # { teamMemberName: ((teamMemberMinutes, teamMemberSeconds), teamId) }
	for teamId in teams:
		teamMemberCount = len(teams[teamId])
		team = teams[teamId]
		for i in range(teamMemberCount//2):
			memberName = list(team.keys())[i]
			selectedTeamMembers[memberName] = (team[memberName], teamId)
	return selectedTeamMembers

def writeSelectedTeamMembers(selectedTeamMembers):
	with open("rez.txt", "w") as file:
		for teamMemberName in selectedTeamMembers:
			teamMemberData = selectedTeamMembers[teamMemberName]
			file.write(f"{teamMemberName} {teamMemberData[0][0]} {teamMemberData[0][1]} - Atrinktas is {teamMemberData[1]} grupes\n")

def sortSelectedTeamMembers(selectedTeamMembers):
	return dict(sorted(selectedTeamMembers.items(), key=lambda item: item[1][0][0]*60 + item[1][0][1]))

teams = sortSelectedTeamMembers(selectTopTeamMembers(sortTeamMembers(readTeams())))
writeSelectedTeamMembers(teams)
