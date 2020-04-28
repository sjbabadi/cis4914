CREATE TABLE videos (
	_id INTEGER PRIMARY KEY AUTOINCREMENT,
	name TEXT,
	link TEXT,
	track_id INTEGER NOT NULL,
	FOREIGN KEY (track_id)
		REFERENCES tracks (_id)
);

CREATE TABLE tracks (
	_id INTEGER PRIMARY KEY AUTOINCREMENT,
	name TEXT
);

CREATE TABLE users (
	_id INTEGER PRIMARY KEY AUTOINCREMENT,
	name TEXT,
	email TEXT,
	admin INTEGER
)

CREATE TABLE users_tracks(
	track_id INTEGER NOT NULL,
	user_id INTEGER NOT NULL,
	FOREIGN KEY (track_id)
		REFERENCES tracks (_id),
	FOREIGN KEY (user_id)
		REFERENCES users (_id)
);

INSERT INTO videos VALUES (1, "Guided Imagery", "X3LlU8TeBZo", 2);
INSERT INTO videos VALUES (2, "Deep Breathing", "N9gNKhyceFo", 3);
INSERT INTO videos VALUES (3, "Progressive Muscle Relaxation", "Y7e59InUyl4", 2);
INSERT INTO videos VALUES (4, "Mindfulness", "I3_RvnvlzRw", 1);
INSERT INTO videos VALUES (5, "Guided Mindfulness Meditation", "P4vbBAf1VRI", 1);
INSERT INTO videos VALUES (6, "Body Scan Meditation", "a00r87d3Vo4", 3);

INSERT INTO tracks VALUES (1, "General Mindfulness");
INSERT INTO tracks VALUES (2, "Anxiety");
INSERT INTO tracks VALUES (3, "Stress Relief");
